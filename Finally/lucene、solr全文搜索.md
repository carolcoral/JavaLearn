<h2>lucene、solr全文搜索</h2>
<p>lucene是一款搜索引擎技术，并非产品，而solr是搜索引擎所在服务器。</p>
<p>应用场景：</p>
<pre><code>1：网站头部的搜索
2：APP端头部搜索
3：做成搜索产品
</code></pre>

<p>搜索原理：</p>
<p><img src="https://i.imgur.com/U2zDm5G.png" /></p>
<ul>
<li>
<p>简介：</p>
<p>Lucene是一个全文搜索框架，而不是应用产品。因此它并不像www.baidu.com 或者google Desktop那么拿来就能用，它只是提供了一种工具让你能实现这些产品。</p>
</li>
<li>
<p>lucene的工作方式</p>
<p>lucene提供的服务实际包含两部分：一入一出。所谓入是写入，即将你提供的源（本质是字符串）写入索引或者将其从索引中删除；所谓出是读出，即向用户提供全文搜索服务，让用户可以通过关键词定位源。</p>
</li>
<li>
<p>写入流程</p>
<p>源字符串首先经过analyzer处理，包括：分词，分成一个个单词；去除stopword（可选），将源中需要的信息加入Document的各个Field中，并把需要索引的Field索引起来，把需要存储的Field存储起来，将索引写入存储器，存储器可以是内存或磁盘</p>
</li>
<li>
<p>读出流程</p>
<p>用户提供搜索关键词，经过analyzer处理，对处理后的关键词搜索索引找出对应的Document，用户根据需要从找到的Document中提取需要的Field</p>
</li>
<li>
<p>概念</p>
<p>analyzer：</p>
<p>Analyzer是分析器，它的作用是把一个字符串按某种规则划分成一个个词语，并去除其中的无效词语，这里说的无效词语是指英文中的“of”、“the”，中文中的“的”、“地”等词语，这些词语在文章中大量出现，但是本身不包含什么关键信息，去掉有利于缩小索引文件、提高效率、提高命中率</p>
<p>document：</p>
<p>用户提供的源是一条条记录，它们可以是文本文件、字符串或者数据库表的一条记录等等。一条记录经过索引之后，就是以一个Document的形式存储在索引文件中的。用户进行搜索，也是以Document列表的形式返回</p>
<p>field：</p>
<p>一个Document可以包含多个信息域，例如一篇文章可以包含“标题”、“正文”、“最后修改时间”等信息域，这些信息域就是通过Field在Document中存储的。    Field有两个属性可选：存储和索引。通过存储属性你可以控制是否对这个Field进行存储；通过索引属性你可以控制是否对该Field进行索引。这看起来似乎有些废话，事实上对这两个属性的正确组合很重要，下面举例说明：还是以刚才的文章为例子，我们需要对标题和正文进行全文搜索，所以我们要把索引属性设置为真，同时我们希望能直接从搜索结果中提取文章标题，所以我们把标题域的存储属性设置为真，但是由于正文域太大了，我们为了缩小索引文件大小，将正文域的存储属性设置为假，当需要时再直接读取文件；我们只是希望能从搜索解果中提取最后修改时间，不需要对它进行搜索，所以我们把最后修改时间域的存储属性设置为真，索引属性设置为假。上面的三个域涵盖了两个属性的三种组合，还有一种全为假的没有用到，事实上Field不允许你那么设置，因为既不存储又不索引的域是没有意义的</p>
</li>
</ul>
<h4>lucene入门示例</h4>
<pre><code>1：新建一个工程
2：导入所需jar包
</code></pre>

<ul>
<li>
<p>入库对象数据实体</p>
<p>1：新建一个入库的实体对象</p>
<p>2：入库IndexWrite</p>
<p>代码如下：</p>
<pre><code>/**
 * 数据对象数据
 * @author likang
 * @date   2018-5-7 上午9:08:24
 */
public class BookEntity implements Serializable{

    private static final long serialVersionUID = 1L;


    private int id;
    private String bookname;
    private String context;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
}
</code></pre>

</li>
<li>
<p>入库</p>
<pre><code>/**
 * 入库
 * @throws Exception 
 */
@Test
public void indexWriter() throws Exception{

    /**
     * 初始化对象数据
     */
    BookEntity book = new BookEntity();
    book.setId(1);
    book.setBookname(&quot;Lucene是一款搜索引擎技术&quot;);
    book.setContext(&quot;Lucene是一款很好的搜索引擎技术，产品有百度，谷歌等&quot;);

    //存储到磁盘的路径（文件夹）
    Directory directory = FSDirectory.open(new File(&quot;./index&quot;));
    //中文分词器
    Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);

    //lucene核心入库类
    IndexWriter iw = new IndexWriter(directory, analyzer, MaxFieldLength.LIMITED);


    /**
     * 参数1：磁盘中关键词的编码
     * 参数2：代表编码的对象数据值
     * 参数3：代表是否支持存储，如果是yes--代表存储对象，如果是no---代表不支持存储对象
     * 参数4：
     *      NOT_ANALYZED：对象数据不支持分词，支持存储，支持索引，支持创建对象
     *      ANALYZED:对象数据支持分词，支持存储，支持索引，支持创建对象
     *      NO：不支持分词，不支持存储，不支持索引，不支持创建对象
     *      ANALYZED_NO_NORMS：对象数据支持分词，不支持创建对象，支持索引，支持存储
     *      NOT_ANALYZED_NO_NORMS：对象数据不支持分词，不支持创建对象，支持索引，支持存储
     */


    Field field1 = new Field(&quot;id&quot;, String.valueOf(book.getId()), Store.YES, Index.NOT_ANALYZED);
    Field field2 = new Field(&quot;bookname&quot;, book.getBookname(), Store.YES, Index.NO);
    Field field3 = new Field(&quot;context&quot;, book.getContext(), Store.YES, Index.ANALYZED);

    //将对象数据封装成document对象
    Document doc = new Document();//创建的对象数据
    doc.add(field1);
    doc.add(field2);
    doc.add(field3);
    //增加对象数据到索引库
    iw.addDocument(doc);
    //关闭入库流
    iw.close();
}
</code></pre>

</li>
<li>
<p>出库</p>
<pre><code> /**
 * 出库
 * @throws Exception 
 */
@Test
public void indexSerach() throws Exception{

    //搜索索引库目录
    Directory directory = FSDirectory.open(new File(&quot;./index&quot;));
    //中文分词器
    Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);

    //出库核心处理类
    IndexSearcher inSearcher = new IndexSearcher(directory);

    //匹配关键词
    QueryParser queryParser = new QueryParser(Version.LUCENE_30, &quot;context&quot;, analyzer);

    Query query = queryParser.parse(&quot;Lucene&quot;);

    /**
     * 参数1：搜索关键词
     * 参数2：匹配显示个数
     */
    TopDocs topdocs = inSearcher.search(query, 4);

    //出库后的对象数据--数组
    ScoreDoc[] sds = topdocs.scoreDocs;

    List&lt;BookEntity&gt; list = new ArrayList&lt;BookEntity&gt;();

    for (ScoreDoc sd : sds) {

        BookEntity book = new BookEntity();

        int index = sd.doc;//获取对象数据的下标
        Document document = inSearcher.doc(index);//根据对象下标，获取对象数据的详细内容
        book.setId(Integer.valueOf(document.get(&quot;id&quot;)));
        book.setBookname(document.get(&quot;bookname&quot;));
        book.setContext(document.get(&quot;context&quot;));
        list.add(book);
    }

    if (list != null &amp;&amp; list.size() &gt; 0) {
        for (int i = 0; i &lt; list.size(); i++) {
            System.out.println(&quot;ID:&quot; + list.get(i).getId());
            System.out.println(&quot;名称：&quot; + list.get(i).getBookname());
            System.out.println(&quot;内容为：&quot; + list.get(i).getContext());
        }
    }
}
</code></pre>

</li>
</ul>

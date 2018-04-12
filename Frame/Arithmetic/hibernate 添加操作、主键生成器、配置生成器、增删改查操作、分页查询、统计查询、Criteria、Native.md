<h1>添加操纵</h1>
<h2>操作代码</h2>
<pre><code>Session session = HibernateUtil.getSession();
Transaction tx = session.beginTransaction();
session.save(dept);
tx.commit();//提交事务
session.close();
</code></pre>

<h2>主键生成策略</h2>
<p>Hibernate提供了一些内置主键生成器</p>
<ol>
<li>
<p>identity</p>
<p>交给数据库自动生成主键值，适合MySQL和SQLServer。（注意：建表时需要追加自动增长设置）</p>
<pre><code>&lt;id name=&quot;no&quot; column=&quot;DEPTNO&quot; type=&quot;integer&quot;&gt;
    &lt;generator class=&quot;identity&quot;&gt;
    &lt;/generator&gt;
&lt;/id&gt;
</code></pre>

</li>
<li>
<p>sequence</p>
<p>采用指定序列生成主键值，适合Oracle和DB2。</p>
<pre><code>&lt;id name=&quot;no&quot; column=&quot;DEPTNO&quot; type=&quot;integer&quot;&gt;
    &lt;generator class=&quot;sequence&quot;&gt;
        &lt;param name=&quot;sequence_name&quot;&gt;xxx&lt;/param&gt;
    &lt;/generator&gt;
&lt;/id&gt;
</code></pre>

</li>
<li>
<p>increment</p>
<p>先查询主键最大值，然后加1再插入，适合各种数据库。</p>
<pre><code>&lt;id name=&quot;no&quot; column=&quot;DEPTNO&quot; type=&quot;integer&quot;&gt;
    &lt;generator class=&quot;increment&quot;&gt;
    &lt;/generator&gt;
&lt;/id&gt;
</code></pre>

</li>
<li>
<p>uuid</p>
<p>采用uuid算法生成一个字符串类型主键值。</p>
<pre><code>&lt;id name=&quot;no&quot; column=&quot;DEPTNO&quot; type=&quot;integer&quot;&gt;
    &lt;generator class=&quot;uuid&quot;&gt;
    &lt;/generator&gt;
&lt;/id&gt;
</code></pre>

<p>(注意：表主键字段类型为varchar)</p>
</li>
<li>
<p>native</p>
<p>hibernate会根据方言设置自动选择identity或sequence等策略。</p>
<pre><code>&lt;id name=&quot;no&quot; column=&quot;DEPTNO&quot; type=&quot;integer&quot;&gt;
    &lt;generator class=&quot;native&quot;&gt;
    &lt;/generator&gt;
&lt;/id&gt;
</code></pre>

</li>
<li>
<p>assigned</p>
<p>忽略，说明hibernate框架不管生成，需要按程序员指定的id值进行添加。</p>
<p>（注意：默认值，需要在代码中调用setId(xxx)设置）</p>
</li>
<li>
<p>自定义主键生成器</p>
<ul>
<li>
<p>编写自定义生成器类,实现IdentifierGenerator接口</p>
<pre><code>public class DeptId implements IdentifierGenerator{

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        //追加自定义主键规则逻辑
        return 100;
    }

}
</code></pre>

</li>
<li>
<p>配置生成器</p>
<pre><code>&lt;id name=&quot;no&quot; column=&quot;DEPTNO&quot; type=&quot;integer&quot;&gt;
    &lt;generator class=&quot;cn.xdl.util.DeptId&quot;&gt;
    &lt;/generator&gt;
&lt;/id&gt;
</code></pre>

</li>
</ul>
</li>
</ol>
<h2>更新操作</h2>
<pre><code>@Test
public void test2(){
    //部分更新，先查询，再修改
    Session session = HibernateUtil.getSession();
    Transaction tx = session.beginTransaction();
    Dept dept = session.get(Dept.class, 21);
    dept.setName(&quot;研发部&quot;);
    session.update(dept);//属于全部更新，根据id做条件更新其他字段值
    tx.commit();
    session.close();
}
</code></pre>

<h2>删除操作</h2>
<pre><code>@Test
public void test3(){
    Dept dept = new Dept();
    dept.setNo(21);

    Session session = HibernateUtil.getSession();
    Transaction tx = session.beginTransaction();
    session.delete(dept);//根据id做条件删除
    tx.commit();
    session.close();
}
</code></pre>

<h2>findById查询</h2>
<pre><code>@Test
public void test4(){
    Session session = HibernateUtil.getSession();
    Dept dept = session.get(Dept.class, 21);
    if(dept != null){
        System.out.println(dept.getName()+&quot; &quot;+dept.getLoc());
    }else{
        System.out.println(&quot;未找到记录&quot;);
    }
    session.close();
}
</code></pre>

<h2>查询操作</h2>
<h3>HQL操作</h3>
<p>Hibernate Query Language 面向对象查询语言</p>
<p>HQL语句是针对映射的对象和属性进行查询操作.</p>
<p>HQL语法结构和SQL相同，支持select..from..where..</p>
<p>HQL和SQL区别：</p>
<ul>
<li>HQL属于面向对象查询;SQL属于面向结构查询</li>
<li>HQL用类名和属性名;SQL用表名和字段名</li>
<li>HQL中类名属性名大小写敏感；SQL中表名和字段名不敏感</li>
<li>HQL不支持select *写法,需要可以省略</li>
<li>HQL不支持join..on..中的on语句</li>
</ul>
<p>SQL: select * from dept
HQL: from Dept</p>
<p>SQL: select * from dept where dname like ?
HQL: from Dept where name like ?</p>
<p>查询所有记录</p>
<pre><code>@Test
public void test5(){
    Session session = HibernateUtil.getSession();
    String hql = &quot;from Dept&quot;;
    Query&lt;Dept&gt; query = session.createQuery(hql);
    List&lt;Dept&gt; list = query.list();//执行HQL
    for(Dept dept:list){
        System.out.println(dept.getNo()+&quot; &quot;+dept.getName()+&quot; &quot;+dept.getLoc());
    }
    session.close();
}
</code></pre>

<p>带条件查询记录</p>
<pre><code>@Test
public void test6(){
    Session session = HibernateUtil.getSession();
    String hql = &quot;from Dept where name like ?&quot;;
    Query&lt;Dept&gt; query = session.createQuery(hql);
    query.setParameter(0, &quot;java%&quot;);//给第一个?设置参数值
    List&lt;Dept&gt; list = query.list();//执行HQL
    for(Dept dept:list){
        System.out.println(dept.getNo()+&quot; &quot;+dept.getName()+&quot; &quot;+dept.getLoc());
    }
    session.close();
}
</code></pre>

<p>分页查询</p>
<pre><code>@Test
public void test7(){
    Session session = HibernateUtil.getSession();
    String hql = &quot;from Dept&quot;;
    Query&lt;Dept&gt; query = session.createQuery(hql);
    //设置分页参数
    query.setFirstResult(5);//抓取记录起点
    query.setMaxResults(5);//最大抓取数量
    List&lt;Dept&gt; list = query.list();//执行HQL
    for(Dept dept:list){
        System.out.println(dept.getNo()+&quot; &quot;+dept.getName()+&quot; &quot;+dept.getLoc());
    }
    session.close();
}
</code></pre>

<p>统计查询</p>
<pre><code>@Test
public void test8(){
    Session session = HibernateUtil.getSession();
    String hql = &quot;select count(*) from Dept&quot;;
    Query&lt;Long&gt; query = session.createQuery(hql);
    Long size = query.uniqueResult();
    System.out.println(&quot;记录总数:&quot;+size);
    session.close();
}
</code></pre>

<h3>Criteria操作</h3>
<p>不足：对分组统计、多表查询、条件查询，会非常复杂。</p>
<p>查询所有记录</p>
<pre><code>@Test
public void test10(){
    Session session = HibernateUtil.getSession();
    Criteria ct = session.createCriteria(Dept.class);//from Dept
    List&lt;Dept&gt; list = ct.list();
    for(Dept dept:list){
        System.out.println(dept.getNo()+&quot; &quot;+dept.getName()+&quot; &quot;+dept.getLoc());
    }
    session.close();
}
</code></pre>

<p>带条件参数查询(Restrictions)</p>
<pre><code>@Test
public void test11(){
    Session session = HibernateUtil.getSession();
    Criteria ct = session.createCriteria(Dept.class);//from Dept
    ct.add(Restrictions.like(&quot;name&quot;, &quot;%java%&quot;));//where name like ?
    ct.addOrder(Order.desc(&quot;no&quot;));//order by no desc
    List&lt;Dept&gt; list = ct.list();
    for(Dept dept:list){
        System.out.println(dept.getNo()+&quot; &quot;+dept.getName()+&quot; &quot;+dept.getLoc());
    }
    session.close();
}
</code></pre>

<h3>NativeSQL操作</h3>
<pre><code>@Test
	public void test15(){
		String sql = "select deptno,dname,loc from dept where dname like :name";
		Session session = HibernateUtil.getSession();
		NativeQuery<Dept> query = session.createNativeQuery(sql,Dept.class);
		query.setParameter("name", "%java%");
		List<Dept> list = query.getResultList();
		for(Dept dept:list){
			System.out.println(dept.getNo()+" "+dept.getName()+" "+dept.getLoc());
		}
		session.close();
	}
</code></pre>


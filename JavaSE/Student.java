package xdl.day16;

public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private int age;

	public Student(int id, String name, int age) throws AgeExcption {
		super();
		setId(id);
		setName(name);
		setAge(age);
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0)
			this.id = id;
		else {
			System.out.println("false");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AgeExcption {
		if (age > 3 && age < 300)
			this.age = age;
		else {
			// System.out.println("年龄不合法false");
			throw new AgeExcption();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return getId() - o.getId();
	}
}

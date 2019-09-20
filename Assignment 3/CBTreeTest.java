public class CBTreeTest
{
	public static void main(String[] ar)
	{
		CBTree cbt = new CBTree("0101011", "TCS");
		System.out.println(cbt.postOrderTraversal());
		System.out.println(cbt.inOrderTraversal());
		System.out.println(cbt.postOrderStructure());
		System.out.println(cbt.inOrderStructure());
	}
}


package application;


public class LTSTreeModel
{
	public int level;
	public int childrens;
	public boolean haveParent;
	public int siblings;
	public int order;

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getChildrens()
	{
		return childrens;
	}

	public void setChildrens(int childrens)
	{
		this.childrens = childrens;
	}

	public boolean isHaveParent()
	{
		return haveParent;
	}

	public void setHaveParent(boolean haveParent)
	{
		this.haveParent = haveParent;
	}

	public int getSiblings()
	{
		return siblings;
	}

	public void setSiblings(int siblings)
	{
		this.siblings = siblings;
	}

	public int getOrder()
	{
		return order;
	}

	public void setOrder(int order)
	{
		this.order = order;
	}
	
	public static TreeNode<String> getSet1() {
		TreeNode<String> root = new TreeNode<String>("root");
		{
			TreeNode<String> node0 = root.addChild("node0");
			TreeNode<String> node1 = root.addChild("node1");
			TreeNode<String> node2 = root.addChild("node2");
			{
				TreeNode<String> node20 = node2.addChild("node20");
				TreeNode<String> node21 = node2.addChild("node21");
				{
					TreeNode<String> node210 = node21.addChild("node210");
					TreeNode<String> node211 = node21.addChild("node211");
				}
			}
			TreeNode<String> node3 = root.addChild("node3");
			{
				TreeNode<String> node30 = node3.addChild("node30");
			}
		}

		return root;
	}
}

package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductAsync
{
	public ObservableList<String> productAsyncClassList = FXCollections.observableArrayList();


	public ProductAsync()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getProductAsyncClassList()
	{
		return productAsyncClassList;
	}


	public void setProductAsyncClassList(ObservableList<String> productAsyncClassList)
	{
		this.productAsyncClassList = productAsyncClassList;
	}
}

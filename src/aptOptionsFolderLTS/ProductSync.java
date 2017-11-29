package aptOptionsFolderLTS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductSync
{
	public ObservableList<String> productSyncClassList = FXCollections.observableArrayList();


	public ProductSync()
	{
		// TODO Auto-generated constructor stub
	}

	public ObservableList<String> getProductSyncClassList()
	{
		return productSyncClassList;
	}


	public void setProductSyncClassList(ObservableList<String> productSyncClassList)
	{
		this.productSyncClassList = productSyncClassList;
	}
}

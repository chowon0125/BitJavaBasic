package item;

public class ItemServiceImpl implements ItemService {
	private Item[] list;
	private int index;
	
	public ItemServiceImpl() {
		// TODO Auto-generated constructor stub
		list = new Item[3];
		index = 0;
	}
	@Override
	public void addCart(Item item) {
		list[index] = item;
		index++;
	}
	
	@Override
	public Item[] list() {
		return list;
	}
	
}

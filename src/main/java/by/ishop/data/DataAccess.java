package by.ishop.data;
import by.ishop.data.product.ProductEntry;

public enum DataAccess {
    INSTANCE;

    private DAO<ProductEntry, Integer> entryDAO = new JPADAOProductEntry();

    public DAO<ProductEntry, Integer> getEntryDAO() {
        return entryDAO;
    }
}
package by.ishop.data;
import by.ishop.data.product.ProductEntry;

public enum DataAccess {
    INSTANCE;

    private DAO<ProductEntry, Long> entryDAO = new JDBCDAOProductEntry();

    public DAO<ProductEntry, Long> getEntryDAO() {
        return entryDAO;
    }
}
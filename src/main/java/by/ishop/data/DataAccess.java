package by.ishop.data;
import by.ishop.data.persists.JPADAOListProductEntriesAll;
import by.ishop.data.persists.JPADAOProductEntry;
import by.ishop.data.product.ProductEntry;

public enum DataAccess {
    INSTANCE;

    private DAO<ProductEntry, Integer> entryDAO = new JPADAOProductEntry();
    private DAOList<ProductEntry, Integer> entriesListDAOall = new JPADAOListProductEntriesAll();

    public DAO<ProductEntry, Integer> getEntryDAO() { return entryDAO; }

    public DAOList<ProductEntry, Integer> getAllEntriesListDAO() { return entriesListDAOall; }
}
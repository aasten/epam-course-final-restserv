package by.ishop.data;

public enum DataAccess {
    INSTANCE;

//    private DAO<ProductEntry> entryDAO = ;

    public DAO<ProductEntry> getEntryDAO() {
        return entryDAO;
    }
}
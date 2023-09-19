package Messages;
//Several Error/Success Messages located
public class Messages {
    public String ElementNotFound = "No element found with given criteria.";
    public String UndefinedInputTypes = "Given input types are not matching.";
    public String ProductSuccessfullyAdded = "New Product Successfully Added";
    public String ProductCannotAdded = "New Product Can Not Added";
    public String ProductSuccessfullyUpdated = "Product Successfully Updated";
    public String ProductSuccessfullySoftDeleted = "Product Successfully Soft Deleted \n" +
            "(Don't Forget About that This is a soft delete operation, \n " +
            "if you would completely delete please call hard delete endpoint!)";
    public String ProductSuccessfullyHardDeleted = "Product Successfully Hard Deleted!";

    public String DeletionOrderWarning = "Before Hard Deletion, soft deletion must be completed!";

}


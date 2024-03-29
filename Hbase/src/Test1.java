import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;


public class Test1 {
private static Configuration conf = null;
/**
* Initialization
*/
static {
conf = HBaseConfiguration.create();
}
/**
* Create a table
*/
public static void createTable(String tableName, String[] familys)
throws Exception {
HBaseAdmin admin = new HBaseAdmin(conf);
if (admin.tableExists(tableName)) {
System.out.println("table already exists!");
} else {
HTableDescriptor tableDesc = new HTableDescriptor(tableName);
for (int i = 0; i < familys.length; i++) {
tableDesc.addFamily(new HColumnDescriptor(familys[i]));
}
admin.createTable(tableDesc);
System.out.println("create table " + tableName + " ok.");
}
}
	

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String tn = "employee";
		String []cf={"personal","address"};
		createTable(tn,cf);

	}

}

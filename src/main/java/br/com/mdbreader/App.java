package br.com.mdbreader;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class App {

    private static final String DB_PATH = "C:\\Users\\Luiz Alberto\\Documents\\desenvolvimento\\workspace_mdb_reader\\bd_supermercados.MDB";

    public static void main( String[] args ) throws IOException {
        Database db = DatabaseBuilder.open(new File(DB_PATH));
        Set<String> tables = db.getTableNames();
        tables.forEach((sTable) -> {
            try {
                Table table = db.getTable(sTable);
                if(table != null) {
                    for(Row row : table) {
                        System.out.println("Look ma, a row: " + row);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}

package mx.summa;

import mx.summa.config.EsClient;

public class Principal {

    public static void main(String argv[]) {
        EsClient esClient = new EsClient();
        esClient.search();
        System.exit(0);
    }
}

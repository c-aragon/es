package mx.summa.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import mx.summa.persistence.User;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

import java.io.IOException;
import java.util.List;

public class EsClient {

    private ElasticsearchClient client;

    public EsClient() {
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("username", "password"));
        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("hostname", 9243, "https"))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                        .setDefaultCredentialsProvider(credentialsProvider));

        RestClient restClient = restClientBuilder.build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        // And create the API client
        client = new ElasticsearchClient(transport);
    }

    public void search() {
        try {
            SearchResponse<User> response = client.search(s -> s
                            .index("sc-user")
                            .query(q -> q
                                    .match(t -> t
                                            .field("_id")
                                            .query("AXUpyCigauynTB7x0zC6")
                                    )
                            ),
                    User.class
            );

            TotalHits total = response.hits().total();
            boolean isExactResult = total.relation() == TotalHitsRelation.Eq;

            if (isExactResult) {
                System.out.println("There are " + total.value() + " results");
            } else {
                System.out.println("There are more than " + total.value() + " results");
            }

            List<Hit<User>> hits = response.hits().hits();
            for (Hit<User> hit : hits) {
                User user = hit.source();
                System.out.println("Found user: " + user + ", score " + hit.score());
            }
        }catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

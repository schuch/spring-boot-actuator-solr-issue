package ch.schu.solrj.collectionissue.collectionissue;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

@Configuration
public class SolrConfig {

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder().withBaseSolrUrl("http://localhost:8983/solr").build();
    }

    @Bean
    public SolrTemplate solrTemplate(@Qualifier("solrClient") SolrClient client) {
        return new SolrTemplate(client);
    }

    @Bean
    public SolrClient solrClientWithCollection() {
        return new HttpSolrClient.Builder().withBaseSolrUrl("http://localhost:8983/solr/techproducts").build();
    }

    @Bean
    public SolrTemplate solrTemplateWithCollection(@Qualifier("solrClientWithCollection") SolrClient client) {
        return new SolrTemplate(client);
    }

}

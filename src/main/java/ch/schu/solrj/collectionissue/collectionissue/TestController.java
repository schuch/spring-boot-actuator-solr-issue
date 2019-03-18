package ch.schu.solrj.collectionissue.collectionissue;

import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final SolrTemplate solrTemplate;
    private final SolrTemplate solrTemplateWithCollection;

    public TestController(
            @Qualifier("solrTemplate") SolrTemplate solrTemplate,
            @Qualifier("solrTemplateWithCollection") SolrTemplate solrTemplateWithCollection) {
        this.solrTemplate = solrTemplate;
        this.solrTemplateWithCollection = solrTemplateWithCollection;
    }

    @GetMapping("/ping")
    public String ping() {
        SolrPingResponse response = solrTemplate.ping();
        return String.valueOf(response.getStatus());
    }

    @GetMapping("/pingWithCollection")
    public String ping2() {
        SolrPingResponse response = solrTemplateWithCollection.ping();
        return String.valueOf(response.getStatus());
    }

}

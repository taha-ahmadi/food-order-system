Packaging: pom vs jar
    pom packaging creates a container for sub modules with jar packaging

General:
    In Application service, Domain Layer should not know about how to fire event.
    Application service decides how and when raise the events.

    Where should I create the domain evenets? in entity or domain service?
    Domain entities are responsible to crete the related events, as they can be directly called from the 
    application service, because in domain driven design, using a domain service is not mandatory. Domain service is
    required if you have access to multiple aggregates in business logic or you have some logic that doesn't fit into
    any entity class.
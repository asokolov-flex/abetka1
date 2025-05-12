# Shopping project


### ShoppingService – manage cart.

### BillingService – pay and billing logic.

### WarehouseService – manage the warehouse.

Each service:

- has its own context boundaries (bounded context);

- communicates with other services via Kafka (asynchronous);

- uses REST for synchronous requests, if necessary;

- is designed according to the DDD principles: Domain, Application, Infrastructure, API.

# tc-demo
Taming JUnit tests with Testcontainers

Presentation for WOOFDA March 2022.

This is a basic Spring Boot / JPA application with external dependencies on a
postgresql database and redis cache.  Some of the tests will not run when the
external dependencies are not available.  Other tests use testcontainers (testcontainers.org)
to provide lightweigh, throwaway containers to provide the dependencies needed
to successfully test the application.

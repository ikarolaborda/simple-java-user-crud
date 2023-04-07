# Simple User CRUD Application

This is a simple Java Spring Boot application that demonstrates a CRUD (Create, Read, Update, Delete) operation on a user entity.

## Prerequisites
- Docker
- Docker Compose

## Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/ikarolaborda/simple-java-user-crud.git
   cd simple-java-user-crud
   ```
   
1.1 Copy the .env file to the project root:

```bash
  cp .env.example .env
```

2. Create a .env file in the project root with the following content. Replace the placeholders with your desired values:

```bash
MYSQL_ROOT_PASSWORD=<your_mysql_root_password>
MYSQL_USER=<your_mysql_user>
MYSQL_PASSWORD=<your_mysql_password>
MYSQL_DATABASE=<your_mysql_database>
```

3. Pre-build the application assets:
    
```bash
    docker build -t user-crud-build -f Dockerfile.build .
    docker cp user-crud-build-container:/app/target ./target
```

4. Build and run the application:

```bash
  docker-compose --env-file app/..env up -d
```

## Testing the Application

1. Create a user:

```bash
curl -X POST \
  http://localhost:8080/api/users \
  -H 'Content-Type: application/json' \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "johndoe@example.org"
```

2. Get all users:

```bash
curl -X GET \
  http://localhost:8080/api/users \
  -H 'Content-Type: application/json'
```

3. Get a user by ID:

```bash
curl -X GET \
  http://localhost:8080/api/users/{id} \
  -H 'Content-Type: application/json'
```

4. Update a user:

```bash
curl -X PUT \
  http://localhost:8080/api/users/{id} \
  -H 'Content-Type: application/json' \
  -d '{
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "janedoe@example.org"
```

5. Delete a user:

```bash
curl -X DELETE \
  http://localhost:8080/api/users/{id} \
  -H 'Content-Type: application/json'
```
### API Endpoints
- GET /api/users: Get all users
- GET /api/users/{id}: Get a user by ID
- POST /api/users: Create a new user
- PUT /api/users/{id}: Update a user by ID
- DELETE /api/users/{id}: Delete a user by ID

### Troubleshooting
There are cases when the necessary files are not being copied to the target directory. In this case, you can run the following command to copy the files manually:

```bash
docker cp .env java-user-crud-app-1:/app/.env #This will copy the env file.
docker cp ../app/target/<build_file_name>.jar java-user-crud-app-1:/app/app.jar #this will copy the build file, this command must be run after the build process that is described above.
```
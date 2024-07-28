# Notifications API

The **Notifications API** is a RESTful service designed to manage push notifications for applications, ensuring users are kept informed about events, promotions, and important updates.

## Features

- **Create Notifications**: Add new notifications for users. *(Future Implementation via SQS Queue)*
- **Retrieve Notifications**: Fetch all notifications or specific ones by ID.
- **Update Notifications**: Modify existing notifications, including marking them as read.
- **Delete Notifications**: Deactivate notifications by ID.

## Endpoints

### Get All Notifications
GET /notifications
```
Fetches all notifications for a specific user.
```

### Get Notification by ID
GET /notifications/{id}
```
Fetches a specific notification by its ID for a user.
```

### Delete Notification by ID
DELETE /notifications/{id}
```
Deactivates a notification by setting its `isActive` flag to false.
```

### Mark Notification as Read
PATCH /notifications/{id}/mark-as-read
```
Marks a notification as read and sets the `readAt` timestamp.
```

## Notification Model

- `notificationId`: Unique identifier for the notification.
- `userId`: Identifier for the user receiving the notification.
- `title`: Title of the notification.
- `message`: Content of the notification.
- `type`: Type of notification (e.g., promotion, alert).
- `createdAt`: Timestamp when the notification was created.
- `read`: Boolean indicating if the notification has been read.
- `readAt`: Timestamp when the notification was read.
- `priority`: Priority of the notification (e.g., high, medium, low).
- `link`: URL or path for more information.
- `isActive`: Boolean indicating if the notification is active.

## Dependencies

- ![Java](https://img.shields.io/static/v1?label=Java&message=17&color=red&style=for-the-badge&logo=java)
- ![Spring Boot](https://img.shields.io/static/v1?label=Spring%20Boot&message=3.3.2&color=green&style=for-the-badge&logo=springboot)
- ![Spring Data JPA](https://img.shields.io/static/v1?label=Spring%20Data%20JPA&message=3.3.2&color=green&style=for-the-badge&logo=spring)
- ![H2 Database](https://img.shields.io/static/v1?label=H2%20Database&message=1.4.200&color=blue&style=for-the-badge&logo=h2)
- ![PostgreSQL](https://img.shields.io/static/v1?label=PostgreSQL&message=42.3.1&color=blue&style=for-the-badge&logo=postgresql)
- ![Lombok](https://img.shields.io/static/v1?label=Lombok&message=1.18.28&color=blue&style=for-the-badge&logo=lombok)
- ![MapStruct](https://img.shields.io/static/v1?label=MapStruct&message=1.5.5.Final&color=blue&style=for-the-badge&logo=java)
- ![SpringDoc OpenAPI](https://img.shields.io/static/v1?label=SpringDoc%20OpenAPI&message=2.3.0&color=green&style=for-the-badge&logo=openapiinitiative)

## Setup

1. Clone the repository:
   ```
   git clone https://github.com/GilbertoJNJ/NotificationAPI.git
   ```

2. Navigate to the project directory:
   ```
   cd notifications-api
   ``` 

3. Build the project using Gradle:
   ```
   ./gradlew build
   ```

4. Run the application:
   ```
   ./gradlew bootRun
   ```

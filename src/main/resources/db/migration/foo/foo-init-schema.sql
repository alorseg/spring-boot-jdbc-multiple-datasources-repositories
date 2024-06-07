CREATE TABLE IF NOT EXISTS users (
    user_id UUID PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (user_id, username, password, email)
VALUES
    ('3bdd33e6-7a5d-414a-9f31-911e0d126295', 'john_doe', 'password1', 'john_doe@example.com'),
    ('58d9570b-6457-4d77-be01-a37e8898f6a9', 'jane_doe', 'password2', 'jane_doe@example.com'),
    ('7ec761b3-0b95-47eb-9178-ee7b0b6e4f19', 'alex_smith', 'password3', 'alex_smith@example.com'),
    ('c5c2bbc8-9ed9-48d9-b1b6-243661339bf2', 'emily_jones', 'password4', 'emily_jones@example.com'),
    ('4d7e7e8b-6474-4f2a-af26-b8018e28a8e1', 'michael_brown', 'password5', 'michael_brown@example.com')
ON CONFLICT DO NOTHING;
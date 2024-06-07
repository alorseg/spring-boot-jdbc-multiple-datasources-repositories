CREATE TABLE IF NOT EXISTS user_grades (
    grade_id SERIAL PRIMARY KEY,
    grade_name VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO user_grades (grade_name)
VALUES
    ('A1'),
    ('A2'),
    ('A3'),
    ('B1'),
    ('B2'),
    ('B3'),
    ('C1'),
    ('C2'),
    ('C3')
ON CONFLICT DO NOTHING;
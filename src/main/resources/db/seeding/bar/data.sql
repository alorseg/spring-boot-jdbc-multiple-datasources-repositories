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
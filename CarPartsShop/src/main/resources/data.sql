USE car_parts_shop;

INSERT INTO roles(role_name)
VALUES ('USER'), ('ADMIN');

INSERT INTO users(first_name, last_name, email, password, created_on)
VALUES ('Emily', 'Filipova', 'hshdhdh.sjjd@example.com',
        'c0d5cbdf17f3dd6e3780223d596894d1bb9a8ae38eb459b5712386defb9e9d82c94580adc02b9faaf0a0063a31c7e0a8',
        '2023-12-09 17:27:13.814752');

INSERT INTO users_roles(user_id, roles_id)
VALUES (1, 2);


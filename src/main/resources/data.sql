-- Remote controllers
INSERT INTO remote_controllers (compatible_with, battery_type, name, brand, price, original_stock)
VALUES
    ('Samsung Crystal UHD 55TU8000', 'AA', 'Samsung Smart Remote', 'Samsung', 49.99, 50),
    ('LG OLED evo C3', 'AAA', 'LG Magic Remote', 'LG', 59.99, 40),
    ('Philips Ambilight 43PUS8508', 'AAA', 'Philips Universal Remote', 'Philips', 39.99, 60);

-- Cimodules
INSERT INTO ci_modules (name, type, price)
VALUES
    ('Samsung CI+ 1.4 Module', 'CI+', 39.99),
    ('LG CAM 4K Module', 'CI+', 49.99),
    ('Philips DVB-CI Module', 'DVB-CI', 34.50),
    ('Sony CI+ Pro Module', 'CI+ Pro', 59.00),
    ('Panasonic SmartCAM Module', 'SmartCAM', 44.95),
    ('Technisat DVB-CI Adapter', 'DVB-CI', 29.99);

-- Wallbrackets
INSERT INTO wall_brackets (size, adjustable, name, price)
VALUES
    ('32-43 inch', true,  'FlexiMount Slim Bracket',         39.99),
    ('32-65 inch', false, 'FixedWall Mount Classic',         29.95),
    ('40-75 inch', true,  'Tilt & Swivel Pro Bracket',       59.00),
    ('55-85 inch', true,  'Full Motion Heavy Duty Mount',    89.50),
    ('24-43 inch', false, 'Compact Flat Wall Bracket',       24.99),
    ('32-75 inch', true,  'Universal SmartBracket Deluxe',   69.95);

-- Televisions
INSERT INTO televisions (type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality,
                         smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light,
                         original_stock, sold, last_purchased, last_sold)
VALUES
    ('Television', 'Samsung', 'Samsung Crystal UHD 55TU8000', 599.99,
     'SIZE_55', 'HZ_120', 'LED', 'UHD_4K',
     true, true, false, true, true, false,
     30, 12, '2025-08-15', '2025-09-20'),

    ('Television', 'LG', 'LG OLED evo C3', 1399.00,
     'SIZE_65', 'HZ_120', 'OLED', 'UHD_4K',
     true, true, true, true, true, true,
     20, 5, '2025-06-12', '2025-09-30'),

    ('Television', 'Philips', 'Philips Ambilight 43PUS8508', 499.00,
     'SIZE_43', 'HZ_60', 'LED', 'FULL_HD',
     true, true, false, true, true, true,
     25, 8, '2025-07-01', '2025-09-25');

-- Users
-- Wachtwoord voor elke user is "test"
INSERT INTO users (username, password, enabled, email, apikey)
VALUES
    ('pietje', '$2a$10$gKNCIzK5xF8Z4QaPz2fzsuvmLfXCyf2fEhABB9U74jcjZupBxdERi', true, 'pietje@test.nl', 'TEST'),
    ('pino',  '$2a$10$ELO43UfEvhwH1O6RFhIzPesDSC7S7NBzqxU1pXoDNZQqETOKVNj/m', true, 'pino@test.nl', 'TEST'),
    ('klaas',  '$2a$10$HXqjf509R19m./qKzQKcY.A2ILsSOrndQRy0kMeH.41PHmcpgvAaa', true, 'klaas@test.nl', 'TEST');

-- Roles
INSERT INTO roles (username, role)
VALUES
    ('pietje', 'ROLE_ADMIN'),
    ('pietje', 'ROLE_USER'),
    ('pino', 'ROLE_USER'),
    ('klaas',  'ROLE_USER');
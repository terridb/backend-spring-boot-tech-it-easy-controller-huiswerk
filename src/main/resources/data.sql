-- INSERT INTO televisions (type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality,
--                          smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light,
--                          original_stock, sold, last_purchased, last_sold)
-- VALUES ('Television', 'Samsung', 'Samsung Crystal UHD 55TU8000', 599.99,
--         'SIZE_55', 'HZ_120', 'LED', 'UHD_4K',
--         true, true, false, true, true, false,
--         30, 12, '2025-08-15', '2025-09-20'),
--
--        ('Television', 'LG', 'LG OLED evo C3', 1399.00,
--         'SIZE_65', 'HZ_120', 'OLED', 'UHD_4K',
--         true, true, true, true, true, true,
--         20, 5, '2025-06-12', '2025-09-30'),
--
--        ('Television', 'Philips', 'Philips Ambilight 43PUS8508', 499.00,
--         'SIZE_43', 'HZ_60', 'LED', 'FULL_HD',
--         true, true, false, true, true, true,
--         25, 8, '2025-07-01', '2025-09-25');
--

-- Remote controllers
INSERT INTO remote_controllers (compatible_with, battery_type, name, brand, price, original_stock)
VALUES
    ('Samsung Crystal UHD 55TU8000', 'AA', 'Samsung Smart Remote', 'Samsung', 49.99, 50),
    ('LG OLED evo C3', 'AAA', 'LG Magic Remote', 'LG', 59.99, 40),
    ('Philips Ambilight 43PUS8508', 'AAA', 'Philips Universal Remote', 'Philips', 39.99, 60);

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

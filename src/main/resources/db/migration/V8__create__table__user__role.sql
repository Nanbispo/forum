CREATE TABLE users_role(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `users_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`users_id`) REFERENCES users (`id`),
    FOREIGN KEY (`role_id`) REFERENCES role (`id`)
);

INSERT INTO `users_role` (`id`, `users_id`, `role_id`) VALUES (1, 1, 1);
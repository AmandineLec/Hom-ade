INSERT INTO element_recoltable (id_element_recoltable, categorie, cooldown, niveau_requis, pv)
VALUES
(
    1, 1, 1, 1, 1
),
(
    2, 1, 1, 1, 1
);

INSERT INTO ressource (id_ressource)
VALUES
(
    2
),
(
    3
),
(
    4
);

INSERT INTO ressources_recoltees (id_element_recoltable, id_ressource, quantite)
VALUES 
(
    1, 3, 1
),
(
    1, 4, 1
),
(
    2, 2, 1
);


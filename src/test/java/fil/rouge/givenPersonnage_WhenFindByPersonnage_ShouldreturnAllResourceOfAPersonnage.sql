INSERT INTO personnage (id, nom, sexe, mail, enabled)
VALUES (
    1, 'Jpp', 1, 'abc@abc', 1
);

INSERT INTO ressource (id_ressource, nom, categorie)
VALUES (
    1, 'bois mort', 1
);

INSERT INTO inventaire_ressources (id_personnage, id_ressource, quantite)
VALUES (
    1, 1, 3
);




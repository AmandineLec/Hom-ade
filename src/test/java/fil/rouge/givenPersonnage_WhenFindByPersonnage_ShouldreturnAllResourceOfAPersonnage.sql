INSERT INTO personnage (id, nom, sexe, enabled, mail, password)
VALUES (
    1, 'Jpp', 1, 1, 'a@a.fr', '1234'
);

INSERT INTO ressource (id_ressource, nom, categorie)
VALUES (
    1, 'bois mort', 1
);

INSERT INTO inventaire_ressources (id_personnage, id_ressource, quantite)
VALUES (
    1, 1, 3
);




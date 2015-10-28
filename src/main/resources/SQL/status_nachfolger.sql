USE bugtracker;
DROP TABLE IF EXISTS STATUS_NACHFOLGER;
CREATE TABLE STATUS_NACHFOLGER (STANR BIGINT, NACHFOLGER BIGINT);

INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (1, 2);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (1, 3);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (1, 4);

INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (2, 1);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (2, 4);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (2, 5);

INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (3, 1);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (3, 2);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (3, 4);

INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (4, 1);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (4, 2);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (4, 3);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (4, 5);

INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (5, 1);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (5, 2);
INSERT INTO STATUS_NACHFOLGER (STANR, NACHFOLGER) VALUES (5, 4);

DROP TABLE IF EXISTS STATUS;
CREATE TABLE STATUS (STANR BIGINT, BEZEICHNUNG VARCHAR(64));

INSERT INTO STATUS (STANR, BEZEICHNUNG) VALUES (1, 'Closed');
INSERT INTO STATUS (STANR, BEZEICHNUNG) VALUES (2, 'InProgress');
INSERT INTO STATUS (STANR, BEZEICHNUNG) VALUES (3, 'Reopened');
INSERT INTO STATUS (STANR, BEZEICHNUNG) VALUES (4, 'Resolved');
INSERT INTO STATUS (STANR, BEZEICHNUNG) VALUES (5, 'WaitingForTriage');


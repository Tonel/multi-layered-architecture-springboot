-- remi : reprise de multi_layered_db.sql pour postgresql 

-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- SET AUTOCOMMIT = 0;
-- SET time_zone = "+00:00";

DROP USER IF EXISTS springtest;
CREATE USER springtest PASSWORD 'springtest';

--
-- Database: multi_layered_db
--
CREATE DATABASE multi_layered_db OWNER springtest;
-- DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- USE multi_layered_db;
\c multi_layered_db springtest


-- --------------------------------------------------------
START TRANSACTION;

--
-- Table structure for table author
--

CREATE TABLE author (
  id serial /*integer*/ NOT NULL,
  name varchar(50) NOT NULL,
  surname varchar(50) NOT NULL,
  birthDate date DEFAULT NULL
); -- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table author
--

INSERT INTO author (id, name, surname, birthDate) VALUES
(1, 'Patricia', 'Brown', NULL),
(2, 'James', 'Smith', '1964-07-01');

-- --------------------------------------------------------

--
-- Table structure for table author_book
--

CREATE TABLE author_book (
  author_id integer NOT NULL,
  book_id integer NOT NULL
); -- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table author_book
--

INSERT INTO author_book (author_id, book_id) VALUES
(1, 2),
(1, 3),
(2, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table book
--

CREATE TABLE book (
  id serial /*integer*/ NOT NULL,
  title varchar(50) NOT NULL,
  releaseDate date DEFAULT NULL
); -- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table book
--

INSERT INTO book (id, title, releaseDate) VALUES
(1, 'The Adventure', '2019-07-14'),
(2, 'DTOs Are Awesome!', '2020-06-11'),
(3, '9 Keys To Academic Success', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table author
--
ALTER TABLE author
  ADD PRIMARY KEY (id);

--
-- Indexes for table author_book
--
ALTER TABLE author_book
  ADD PRIMARY KEY (author_id,book_id);

--
-- Indexes for table book
--
ALTER TABLE book
  ADD PRIMARY KEY (id);
--   ADD KEY book_id_fk (book_id),
--   ADD KEY author_id_fk (author_id);

--
-- AUTO_INCREMENT for dumped tables
--

/*
--
-- AUTO_INCREMENT for table author
--
ALTER TABLE author ALTER COLUMN id TYPE integer NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table book
--
ALTER TABLE book
  ALTER COLUMN id integer NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
*/

--
-- Constraints for dumped tables
--

--
-- Constraints for table author_book
--
ALTER TABLE author_book
  ADD CONSTRAINT author_id_fk FOREIGN KEY (author_id) REFERENCES author (id),
  ADD CONSTRAINT book_id_fk FOREIGN KEY (book_id) REFERENCES book (id);

COMMIT;


-- Create the database if it doesn't exist
DO
$$
    BEGIN
        IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'payment_ndb') THEN
            PERFORM dblink_exec('dbname=postgres', 'CREATE DATABASE payment_ndb');
        END IF;
    END
$$;

-- Connect to the database
\c payment_ndb;

-- Create the table if it doesn't exist
CREATE TABLE IF NOT EXISTS payments (
                                        id UUID PRIMARY KEY,
                                        amount DOUBLE PRECISION NOT NULL DEFAULT 0.0,
                                        currency VARCHAR(3) NOT NULL,
                                        payment_method VARCHAR(50),
                                        description TEXT,
                                        status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
                                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

--------------------------------------------------------------------------------
-- Øvelse 2
--------------------------------------------------------------------------------

-- Q7

-- a)

implikasjon :: Bool -> Bool -> Bool
implikasjon p q = not p || q

-- b)

q2a :: Bool -> Bool -> Bool
q2a p q = (p || q) && (not p || not q)

main :: IO()
main = do
    putStrLn "Resultat: "
    print(implikasjon False True)
    print(q2a True True)


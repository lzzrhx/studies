-- List
import Data.List

--------------------------------------------------------------------------------
-- Øvelse 1
--------------------------------------------------------------------------------

-- Q6
-- a)
t = [0..99]

-- b)
t1 = [x | x <- t, x > 10, x < 20]

-- c)
-- 2 * x - 3 = y
-- x = (y + 3 ) / 2
t2 = [ (y + 3) / 2 | y <- t1]

-- Q11
q11A = [0,2,4]
q11B = [1,3,5]
q11r = [[0,1], [0,3], [2,5]]
q11p = [[0,0], [0,2]]
q11P = [1..100]
--q11r2 = [???]



a = [1..10]
r = [[x,y]| x <- a, y <- a, x + y <= 3]
--x = [ [x, y]|x
--x = map head nub r 

pq_tabell = [[True,True],[True,False],[False,True],[False,False]]

star :: [Bool] -> Bool
star pq = (not.head)(pq) && (not.last)(pq) 

circ :: [Bool] -> Bool
circ pq = (not.head)(pq) || (not.last)(pq) 


main :: IO()
main = do
    putStrLn "Resultat: "
    putStrLn "p ⋆ q: "
    print(map star pq_tabell)
    putStrLn "p ∘ q: "
    print(map circ pq_tabell)


import Data.List (sort)

-- Liste:
-- Elementer kan endres
lTest = [1, 2, 3]

-- Tupler:
-- Elementer kan IKKE endres
-- Elementtyper kan blandes
tTest = (1, 2, 3)


-- Liste av naturlige tall fra 0 til 100
nTest = [0,1..100]

-- Mengdebygger (list comprehension)
-- x tar verdi fra listen t, x er mindre enn 20, x er større enn 10
nTest1 = [x | x <- t, x < 20, x > 10]

-- ...
nTest2 = [(y+3)/2 | y <- t1]

-- General functions
increment x = x + 1
isEven n = n `mod` 2 == 0
isOdd n = n `mod` 2 == 1

-- Pattern matching
coffee :: String -> String
coffee "Espresso" = "Strong coffee"
coffee "Latte" = "Milky"
coffee _ = "Unknown"

-- Guards
bookCategory :: Int -> String
bookCategory pages | pages < 100 = "Short Story"
                   | pages < 300 = "Novel"
                   | pages < 1000 = "Big book!"
                   | otherwise = "Unknown"

-- Where clause
popDensity :: (Float, Float) -> Float
popDensity (population, area) = density where density = population / area

-- Recursion
factorial :: Int -> Int
factorial 0 = 1
factorial n = n * factorial (n - 1)

-- Map
mapTest = map increment [1..10]

-- Filter
filterTest = filter isEven [1..10]

-- Sort
sortTest = sort [5,4,2,8,6,1,3,9,0,7]

-- Foldl
foldlTest = foldl (+) 0 [1..10]

-- ZipWith
zipWithTest = zipWith (+) [1..5] [1..5]

-- takeWhile / dropWhile
takeWhileTest = takeWhile (<3) [0..10]
dropWhileTest = dropWhile (<3) [0..10]

-- all / any
allTest = all isEven [0..10]
anyTest = any isEven [0..10]

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

-- Q14
q14f :: Integer -> Integer
q14f x = 

main :: IO()
main = do
    putStrLn "Resultat: "
    print(t2)


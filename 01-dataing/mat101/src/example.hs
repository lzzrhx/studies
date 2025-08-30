--import Data.List (sort)

-- List
import Data.List

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

-- List functions
-- head - first element in list
-- tail - all elements in list except first
-- last - last element in list
-- init - all elements except last
-- null - returns true if given list is empty
-- reverse - reverses list order
-- length - check the length of a given list
-- take x - create sublist of first x elements from a given list
-- drop x - create a sublist without first x elements from a given list
-- maxmimum - returns the maxmium value from a list
-- minimum - returns the minimum value from a list
-- sum - returns the sum of all values in a given list
-- product - returns the product of all the values in a given list
-- elem x - checks if a value exists in a given list

-- Function composition:
fooeven :: Int -> Bool
foonoteven :: Bool -> String
fooeven x = if x `rem` 2 == 0
  then True
else False
foonoteven x = if x == True
  then "This is an even number"
else "This is an odd number"
--print((foonoteven.fooeven)(2))

-- List module


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


main :: IO()
main = do
    putStrLn "Resultat: "
    print((foonoteven.fooeven)(2))


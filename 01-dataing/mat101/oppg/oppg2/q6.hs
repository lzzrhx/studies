--------------------------------------------------------------------------------
-- Q6
--------------------------------------------------------------------------------

import Numeric.Natural

nat = [0..]

multi :: Natural -> Natural -> Natural
multi n m = n * m

main :: IO()
main = do
    putStrLn "Resultat: "
    print(multi 1 2)


filterunique :: [Int] -> [Int]
filterunique [] = []
filterunique (n:ns) =
-- retain n only if it is not an element of ns --
if (not (n `elem` ns))
   then n : (filterunique ns)
   else filterunique ns

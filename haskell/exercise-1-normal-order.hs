{-# OPTIONS_GHC -Wall #-}
module Exercise1 where

import Debug.Trace

--to compile run in the file directory ghc --make -main-is Exercise1 exercise-1-normal-order.hs and then run executable file
-- or to just run it runhaskell exercise-1-normal-order.hs

--samples from https://hackhands.com/lazy-evaluation-works-haskell/

-- haskell allow to create only pure functions with no side effects so we have to wrap side effects with IO monad

--When called, trace outputs the string in its first argument, before returning the second argument as its result.'
--You must keep in mind that due to lazy evaluation your traces will only print if the value they wrap is ever demanded.
main :: IO()
main = print $ (True) &&& (trace ("superConsuming Operation is called") (superConsumingOperation 1))

(&&&) :: Bool -> Bool -> Bool
True  &&& x = x
False &&& x = False

superConsumingOperation :: Integer -> Bool
superConsumingOperation 0  = False
superConsumingOperation n = True

-- ctrl x + o - switch window
-- ctrl c + b - run interpreter
-- ctrl x + s - safe buffer
-- ctrl x + c - save buffers - kill emacs
-- OR dynamic breakpoints using GHCI to observer intermediate values
-- :break Exercise1 25
-- main
-- :sprint _result (seq to force evaluation)

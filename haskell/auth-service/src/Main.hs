{-# LANGUAGE OverloadedStrings #-}
import Web.Scotty
import Network.HTTP.Types

main = scotty 8080 $ do
    get "/api/v1" $ do
        text "Auth service is alive!!"

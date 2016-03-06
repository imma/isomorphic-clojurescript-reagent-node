# Isomorphic ClojureScript with Reagent and Node.js

This is an example application that demonstrates how to build an
isomorphic ClojureScript application using Reagent (react.js) that
targets Node.js

See
http://blog.testdouble.com/posts/2016-01-21-isomorphic-clojurescript.html
for more in-depth information.

## Installation

`block bootstrap` to build the dependencies.  Then `require` to use the
blocks.  To rebuild this project, run `script/bootstrap`.

## Usage

Run `script/server` to start server

# Inventory

## Repo overhead

    README.md
    LICENSE
    .gitignore
    bin/.gitignore

## Builds

    project.clj
    package.json

### Ignored builds

    node_modules
    resources

## Blocks

    Blockfile.json
    script/bootstrap
    script/fresh
    script/profile
    script/server

## ClojureScript

### Client

    src-client/demo/client.cljs

### Server

    src-server/demo/server.cljs

### Common

    src/demo/core.cljs
    src/site/tools.cljs

# License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


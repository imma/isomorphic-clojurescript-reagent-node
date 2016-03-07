# Isomorphic ClojureScript with Reagent and Node.js

This is an example application that demonstrates how to build an
isomorphic ClojureScript application using Reagent (react.js) that
targets Node.js

See
http://blog.testdouble.com/posts/2016-01-21-isomorphic-clojurescript.html
for more in-depth information.

Incorporates code from https://github.com/scpike/memtest for the memtest
game; from https://github.com/kanaka/cljs-bootstrap for the cljs repl
and runner.

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

## Builds

    project.clj
    package.json

### Ignored builds

    node_modules
    resources/public/js
    resources/public/css

### Static files

    sources/public/static

## Blocks

    Blockfile.json
    script/bootstrap
    script/fresh
    script/profile
    script/server

## ClojureScript

### Namespaces

    demo.client
    demo.server
    demo.core
    demo.tools

### Core

Defines the app state, pages, and views.  Used by client and server.

    src/demo/core.cljs

### Client, depends on Core

Renders a core view. Compiles into
`resources/public/js/client/client.js` run by the browser.

    src-client/demo/client.cljs

### Tools, depends on Core

Renders a static page using a core view.

    src/demo/tools.cljs

### Server, depends on Tools

Serves a static page rendered with tools.  Compiles into
`resources/public/js/server/server.js` run by node.

    src-server/demo/server.cljs

# License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


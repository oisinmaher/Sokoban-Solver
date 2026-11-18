# Plan: Clean GUI for Sokoban

## Goal
A polished, clean GUI for displaying (and solving) the Sokoban game, usable
without any installation: a single self-contained HTML file that opens in a
browser, plus tooling.

## Constraints
- Sandbox has no JDK, no tkinter/pygame, no node, no internet, no root.
- The repo currently contains a Java BFS solver + old clunky Swing GUI.
- Therefore the clean GUI is delivered as `gui/sokoban.html` (vanilla HTML/CSS/JS).

## Features
1. **Board rendering** — crisp CSS-grid board: floor, walls, goals (holes),
   boxes, player; distinct colors; box-on-goal and player-on-goal states.
2. **Built-in levels** — several classic small Sokoban levels, selectable.
3. **Level input** — paste/edit a text level (standard `# @ $ . * +` syntax)
   and load it; live preview.
4. **Solve** — BFS optimal solver (moves) in JS, running in the browser.
5. **Solution playback** — animate moves step by step with speed control,
   play/pause/step/reset, move & push counters, status (solved / unsolvable).
6. **Manual play** — arrow keys / WASD to play the level yourself, undo, reset.
7. **Verification** — `test/test_solver.py` (Python port of the same BFS) that
   cross-validates solver behavior on sample levels; run with `python3`.

## Steps
- [x] Explore repo, pick approach
- [x] Plan committed
- [ ] Build `gui/sokoban.html`
- [ ] Write `test/test_solver.py` cross-check + run
- [ ] Update README
- [ ] Final commit

## Status
In progress.

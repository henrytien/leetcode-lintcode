# How to become a contributor and submit your own code

## Contributor License Agreement

Contributions to this project must be accompanied by a Contributor License Agreement. 

## Step by step

- Fork this repo

- Run a script to auto-generate files.

  All problems have related topics, so you can put your solution in leetcode folder, these directories created by the problems tag. You need to see the problem of related topics or your method, and go to the directory, execute a script.

  such as `cd leetcode/binary_search` 

  and `../../scripts/comments_cpp.sh https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/` 

  that will be auto-generate a folder and a cpp source file, if you want to create a python solution, just replace the comments_cpp.sh to comments_py.sh, now scripts support create cpp, python, go, java . 

- Syncing a fork

  Sync a fork of a repository to keep it up-to-date with the upstream repository. See [document](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/syncing-a-fork) for more detail.

- Pull request

  From your branch of develop to origin branch of develop. Make sure your commit doesn't have conflict.

## Code reviews

All submissions, including submissions by project members, require review. We use GitHub pull requests for this purpose. Consult [GitHub Help](https://help.github.com/articles/about-pull-requests/) for more information on using pull requests.


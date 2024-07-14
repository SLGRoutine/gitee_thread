1. add将源码或其他加入到git托管区
2.commit 将托管区中的代码提价到本地git仓库中，commit时一定要提供一个信息
3.push将本地仓库中的代码版本1 提交到 gitee中央仓库服务器
    当前条件：本地有一个仓库  gitee中有一个仓库
    所以会导致  push  rejected 问题
4.解决push rejected问题
找到项目的目录  ->进入   git bash命令行
输入：git push origin master --alow-unrelated-hittories
      git push -u origin master -f
OK

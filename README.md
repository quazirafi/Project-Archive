# Project300
I am writing it such a way that will get you quickly started in Git for our project 300 purposes. Hope it will be helpful.
To learn more basics,please see https://git-scm.com/documentation

1.Installing git 
   a) Download the Git for Windows installer package.Below is your download link
        https://git-scm.com/download/win
   b) After you have installed the package,open Git Bash.vbs from the Git folder of the Programs directory to open a command window. 

2.Basics of git
   a)What is Git?
   Git is a free and open source distributed version control system designed to handle everything from small to very large projects with speed and efficiency.

   b)Then what is GitHub?
   GitHub is a Git repository hosting service, but it adds many of its own features.

   c)What i need to learn to get started to use Git on my Project 300?
       (i) Sign up in GitHub
         -go to www.github.com
         -sign up for a github account
       (ii)Create a Repository.
         -use this link to see how to create a repo-  https://help.github.com/articles/create-a-repo/
       (iii)Push the project directory to your github repository
         -If you have git shell,then got to your project directory by using cd <project directory> in your terminal
         -If you have Git Bash then go to your project directory in your pc(can be any directory,for learning purpose better use a very simple project at first) and right  
          click-->Git Bash Here and a terminal(command line interface) will be displayed with the directory already being in your project directory.
         -Now that you are in terminal(in git shell/git bash),you can now push your directory to your GitHub repository using simple commands
         -Here is the link to how you can do that- https://help.github.com/articles/adding-an-existing-project-to-github-using-the-command-line/ 
   
    3.How we will work in git?
        A demonstration: 
         I am the owner of the project.This is my repositor link- https://github.com/Karyotyper/Project300/tree/Temporary
         Step1:  I have uploaded the project in github repository.Here is the link - https://github.com/Karyotyper/Project300/tree/Temporary (same as above)
         Step 2: You all need to create your github account and give me your profile link. Then, i will add you as a contributor to the Project300 project
         Step 3: If you go the link given above ,you can see that there is a dropdown named as Branch:master,don't use it. Click on it,select Temporary from the list.
         Step 4: To the top right, you can see a button called Fork.Click on it.It will copy my project to your own repository.Now you have my project(Temporary           version) in your own repository.
         Step 5: go to a directory in your own pc,go to Git shell/Git bash and write the following commands.
                     git clone https://github.com/<your username>/Project300.git
         Step 6: Now you have my project in your own pc. 
       **Step 7: Add your codes to the project
       **Step 8: After you have finished adding your own codes the project, write the following commands.
                      git checkout -b <Your branch name> (it will create a new branch called "Temp" of your own,nijer naam o ditey parish tora)
                      git add . (it will add all the files for staging)
                      git commit -m "(Your name) added addition service class functions to the project"
                      git push origin <Your branch name> ( it will push the changes you made in the project to your own repository in a branch name Temp.To see the changes, click on
                                               branch and you will see the latest changes you made)
          Step 9:  But how would the changes be merged to the project that I have? In your Temp branch, see the "Pull request" button?  
                       Click Pull request-->Create Pull request
                       I am the owner of the project.So,the request will be sent to me and i will then work to merge the codes,you all don't need to worry then.


          Step 10: Now that i have merged the changes,so i have the most updated version of the project...and now suppose i made some changes too. Next time when you work,you sit on your pc go to your
                        project folder and pull the updated version using this command-
                                  *****  git pull https://github.com/Karyotyper/Project300.git Temporary  ****(THIS IS MUST)
                        I repeat, use this command everytime you start working.
                        Then continue from Step 7 but this time use git checkout Temp (you don't need -b because it is used to create branch,you have created 
                        once,you don't need to do it again)


        [Very Important Note: Make a branch like i said "Temp"/"Any branch name you want" of your own project,It is a good practice to avoid using master very frequently]
                       
        BRANCH BASICS:        
                  git checkout -b Siam (It would create a branch named Siam)
                   <now i would like to add a readme.txt file in this branch,suppose i have added and want to commit the changes to Siam branch>
                  git add . (adds all the files)
                  git commit -m "I have added a file named readme.txt
                  git push origin Siam (file changes added to Siam branch)
                   <now i dnt have the changes in master branch...what should I do??>
                  git checkout master  (It would checkout to master branch)
                  git merge Siam (merge the master branch with Siam branch)
                

-Hi I am Zinia,let's learn Git
-Hi,I am Siam, I am learning Git too!!!
     
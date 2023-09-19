import os
import signal

pid = int(input("PID de Wordpad ? : "))
os.kill(pid,signal.SIGINT)
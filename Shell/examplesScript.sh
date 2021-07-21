echo "Add two numbers!"
sum=$(($1+$2))
echo $sum
age=50
if [ $age -ge 50 ]
	then
		echo "Over the hill!"
	else
		echo "wippersnapper!"
	fi
echo "Loop 1:"

for i in {1..5}
do
	echo $i
done

echo "Loop 2:"

for i in 1 2 3
do
	echo $i
done

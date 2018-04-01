#!/bin/bash
partition_list=(`df -h | awk 'NF>3&&NR>1{sub(/%/,"",$(NF-1));print $NF,$(NF-1)}'`)
critical=90
notification_email()
{
    emailuser='yzq@yunfatong.com'
    emailpasswd='rihoko991328'
    emailsmtp='smtp.qq.com'
    sendto='donell@yunfatong.com'
    title='Disk Space Alarm'
    /sendEmail-v1.56/sendEmail -f $emailuser -t $sendto -s $emailsmtp -u $title -xu $emailuser -xp $emailpasswd -o tls=no
}
crit_info=""
for (( i=0;i<${#partition_list[@]};i+=2 ))
do
    if [ "${partition_list[((i+1))]}" -lt "$critical" ];then
        echo "OK! ${partition_list[i]} used ${partition_list[((i+1))]}%"
    else        
            if [ "${partition_list[((i+1))]}" -gt "$critical" ];then
                crit_info=$crit_info"Warning!!! ${partition_list[i]} used ${partition_list[((i+1))]}%\n"
            fi 
    fi
done
if [ "$crit_info" != "" ];then
    echo -e $crit_info | notification_email
fi
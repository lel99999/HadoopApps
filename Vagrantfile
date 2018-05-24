Vagrant.configure("2") do |config|

  config.vm.provider "virtualbox" do |v|
    v.memory = "1024"
    v.cpus = 2
    v.customize ["modifyvm", :id, "--cpuexecutioncap", "70"]
  end
  config.vm.define "hdptomcat9" do |hdptomcat9
    hdptomcat9.vm.box = "bento/centos-6.7"
    hdptomcat9.vm.hostname = "hdptomcat9.hdpdev.com"
    hdptomcat9.vm.network "private_network", ip: "192.168.60.180"
    hdptomcat9.vm.provision "shell", :inline => "sudo echo '192.168.60.180 hdptomcat9.hdpdev.com hdptomcat9' >> /etc/hosts"
    en01.vm.provision "ansible" do |ansible|
      ansible.playbook = "deploy_allnodes.yml"
    end
  end
  #config.vm.provision "ansible" do |ansible|
    #ansible.playbook = "tomcat9setup.yml"
    #ansible.inventory_path = "vagrant_hosts"
    #ansible.tags = ansible_tags
    #ansible.extra_vars = ansible_extra_vars
    #ansible.limit = ansible_limit
  #end

end
